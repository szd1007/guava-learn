import os
import azure.cognitiveservices.speech as speechsdk

# This example requires environment variables named "SPEECH_KEY" and "SPEECH_REGION"
speech_config = speechsdk.SpeechConfig(subscription=os.environ.get('AZURE_SPEECH_KEY'), region=os.environ.get('AZURE_SPEECH_REGION'))

speech_config.speech_synthesis_voice_name='zh-CN-YunyeNeural'
speech_config.set_speech_synthesis_output_format(speechsdk.SpeechSynthesisOutputFormat.Audio48Khz96KBitRateMonoMp3)

speech_synthesizer = speechsdk.SpeechSynthesizer(speech_config=speech_config, audio_config=None)

text = "今天天气真不错，ChatGPT真好用。"
result = speech_synthesizer.speak_text_async(text).get()

stream = speechsdk.AudioDataStream(result)

stream.save_to_wav_file("/Users/zm/aigcData/tts2.mp3")

