import torch
from PIL import  Image
from io import BytesIO
from IPython.display import display
from diffusers import DiffusionPipeline
pipeline = DiffusionPipeline.from_pretrained("gsdf/Counterfeit-V2.5")

pipeline.to("cuda")

#prompt = "((masterpiece,best quality)),1girl, solo, animal ears, rabbit, barefoot, knees up, dress, sitting, rabbit ears, short sleeves, looking at viewer, grass, short hair, smile, white hair, puffy sleeves, outdoors, puffy short sleeves, bangs, on ground, full body, animal, white dress, sunlight, brown eyes, dappled sunlight, day, depth of field"

negative_prompt = "EasyNegative, extra fingers,fewer fingers,"

prompt = "((masterpiece,best quality)),1girl, solo, animal ears, rabbit, barefoot, knees up, dress, sitting, rabbit ears, short sleeves, looking at viewer, grass, short hair, smile, white hair, puffy sleeves, outdoors, puffy short sleeves, bangs, on ground, full body, animal, white dress, sunlight, brown eyes, dappled sunlight, day, depth of field "
negative_prompt = " EasyNegative, extra fingers,fewer fingers, "

image = pipeline(prompt=prompt, negative_prompt=negative_prompt).images[0]

image

display(image)