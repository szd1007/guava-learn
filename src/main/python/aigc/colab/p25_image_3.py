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

openpose = OpenposeDetector.from_pretrained("lllyasviel/ControlNet")

image_file1 = "../aigcData/rodin.jpg"
original_image1 = load_image(image_file1)
openpose_image1 = openpose(original_image1)

image_file2 = "../aigcData/discobolos.jpg"
original_image2 = load_image(image_file2)
openpose_image2 = openpose(original_image2)

images = [original_image1, openpose_image1, original_image2, openpose_image2]
draw_image_grids(images, 2, 2)


from diffusers import StableDiffusionControlNetPipeline, ControlNetModel
from diffusers import UniPCMultistepScheduler
import torch

controlnet = ControlNetModel.from_pretrained(
    "fusing/stable-diffusion-v1-5-controlnet-openpose", torch_dtype=torch.float16
)
pipe = StableDiffusionControlNetPipeline.from_pretrained(
    "runwayml/stable-diffusion-v1-5",
    controlnet=controlnet,
    torch_dtype=torch.float16,
)
pipe.scheduler = UniPCMultistepScheduler.from_config(pipe.scheduler.config)
pipe.enable_model_cpu_offload()
pipe.enable_xformers_memory_efficient_attention()

poses = [openpose_image1, openpose_image2, openpose_image1, openpose_image2]

generator = [torch.Generator(device="cpu").manual_seed(42) for i in range(4)]
prompt1 = "spiderman character, best quality, extremely detailed"
prompt2 = "young chinese nude girl character, best quality, extremely detailed"

output = pipe(
    [prompt1, prompt1, prompt2, prompt2],
    poses,
    negative_prompt=["monochrome, lowres, bad anatomy, worst quality, low quality"] * 4,
    generator=generator,
    num_inference_steps=20,
)





