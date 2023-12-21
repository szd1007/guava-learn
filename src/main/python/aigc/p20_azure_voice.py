import os
import azure.cognitiveservices.speech as speechsdk

# This example requires environment variables named "SPEECH_KEY" and "SPEECH_REGION"
speech_config = speechsdk.SpeechConfig(subscription=os.environ.get('AZURE_SPEECH_KEY'), region=os.environ.get('AZURE_SPEECH_REGION'))
audio_config = speechsdk.audio.AudioOutputConfig(use_default_speaker=True)

# The language of the voice that speaks.
#speech_config.speech_synthesis_voice_name='zh-CN-XiaohanNeural'
speech_config.speech_synthesis_voice_name='zh-CN-YunyeNeural'
speech_synthesizer = speechsdk.SpeechSynthesizer(speech_config=speech_config, audio_config=audio_config)

text = "今天天气真不错，ChatGPT真好用。"
speech_synthesizer.speak_text_async(text).get()


ssml = """<speak version="1.0" xmlns="http://www.w3.org/2001/10/synthesis"    
   xmlns:mstts="https://www.w3.org/2001/mstts" xml:lang="zh-CN">
       <voice name="zh-CN-YunyeNeural">       
        这个老6正在街上闲逛，突然看见一个美女，说到：        
        <mstts:express-as role="Boy" style="cheerful"> 
                   “妈妈，我想要买个新玩具”        
                   </mstts:express-as>    
        </voice>    
        <voice name="zh-CN-XiaomoNeural">       
         母亲放下包，说：        
         <mstts:express-as role="SeniorFemale" style="angry">
                     “我看你长得像个玩具。”      
         </mstts:express-as>    
        </voice>
        </speak>"""

ssml2 = """<speak version="1.0" xmlns="http://www.w3.org/2001/10/synthesis"
       xmlns:mstts="https://www.w3.org/2001/mstts" xml:lang="en-US">
    <voice name="en-US-JennyNeural">
        <mstts:express-as style="excited">
            That'd be just amazing!
        </mstts:express-as>
        <mstts:express-as style="friendly">
            What's next?
        </mstts:express-as>
    </voice>
</speak>"""

#speech_synthesizer.speak_ssml_async(ssml).get()
