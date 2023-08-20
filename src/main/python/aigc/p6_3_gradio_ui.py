import gradio as gr
from p6_2_chatai_token import Conversation
prompt ="""你是一个中国厨师，用中文回答做菜的问题。你的回答需要满足以下要求：
1.你的回答必须是中文
2.回答限制在100个字以内"""

conv = Conversation(prompt, 10)

def answer(question, history=[]):
    history.append(question)
    response = conv.ask(question)
    history.append(response)
    responses = [(u, b) for u, b in zip(history[::2], history[1::2])]
    return responses, history

with gr.Blocks(css="#chatbot{height:300px} .overflow-y-auto{height:500px}") as demo:
    chatbot = gr.Chatbot(elem_id="chatbot")
    state = gr.State([])

    with gr.Row():
        txt = gr.Textbox(show_label=False, placeholder="Enter text and press enter", container=False)

    txt.submit(answer, [txt, state], [chatbot, state])

demo.launch()