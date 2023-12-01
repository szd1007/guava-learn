import re


def extract_temperatures(text):
    # 使用正则表达式查找白天的最高气温和夜间的最低气温
    max_temperatures = re.findall(r'白天 最高气温(\d+)℃', text)
    min_temperatures = re.findall(r'夜间 最低气温(-?\d+)℃', text)

    # 将找到的温度信息转换为字典格式
    temperature_data = {
        "max_temperature": [int(temp) for temp in max_temperatures],
        "min_temperature": [int(temp) for temp in min_temperatures]
    }
    return temperature_data


# 示例文本
sample_text = "今天白天 最高气温15℃ 晴; 今天夜间 最低气温0℃ 晴; 明天白天 最高气温13℃ 晴间多云; 明天夜间 最低气温-1℃ 多云"

# 调用函数并打印结果
temperature_data = extract_temperatures(sample_text)
print(temperature_data)