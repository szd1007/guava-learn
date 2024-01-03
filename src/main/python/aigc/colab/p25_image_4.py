import cv2
import numpy as np
import matplotlib.pyplot as plt
from diffusers.utils import load_image
from PIL import Image

from diffusers import StableDiffusionControlNetPipeline, ControlNetModel
import torch

from controlnet_aux import OpenposeDetector
from diffusers.utils import load_image

def draw_image_grids(images, rows, cols):
  # Create a rows x cols grid for displaying the images
  fig, axes = plt.subplots(2, 2, figsize=(10, 10))

  for row in range(rows):
    for col in range(cols):
      axes[row, col].imshow(images[col + row * cols])
  for ax in axes.flatten():
    ax.axis('off')
  # Display the grid
  plt.show()

from diffusers import StableDiffusionControlNetPipeline, ControlNetModel
from diffusers import UniPCMultistepScheduler
import torch

controlnet = ControlNetModel.from_pretrained(
    "lllyasviel/sd-controlnet-scribble", torch_dtype=torch.float16
)
pipe = StableDiffusionControlNetPipeline.from_pretrained(
    "runwayml/stable-diffusion-v1-5",
    controlnet=controlnet,
    torch_dtype=torch.float16,
)
pipe.enable_model_cpu_offload()
pipe.enable_xformers_memory_efficient_attention()

from diffusers.utils import load_image

image_file = "../aigcData/scribble_dog.png"
scribble_image = load_image(image_file)

generator = [torch.Generator(device="cpu").manual_seed(2) for i in range(4)]
prompt = "dog"
prompt = [prompt + t for t in [" in a room", " near the lake", " on the street", " in the forrest"]]
output = pipe(
    prompt,
    scribble_image,
    negative_prompt=["lowres, bad anatomy, worst quality, low quality"] * 4,
    generator=generator,
    num_inference_steps=50,
)





