#https://huggingface.co/docs/api-inference/detailed_parameters  官方文档

import os, requests, json

API_TOKEN = os.environ.get("HUGGINGFACE_API_KEY")

model = "google/flan-t5-xxl"
API_URL = f"https://api-inference.huggingface.co/models/{model}"
headers = {"Authorization": f"Bearer {API_TOKEN}", "Content-Type": "application/json"}


def query(payload, api_url=API_URL, headers=headers):
    data = json.dumps(payload)
    response = requests.request("POST", api_url, headers=headers, data=data)
    return json.loads(response.content.decode("utf-8"))


question = "Please answer the following question. What is the capital of France ?"
data = query({"inputs": question})

print(data)