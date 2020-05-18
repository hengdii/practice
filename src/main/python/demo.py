import pandas as pd
import numpy as np
import sklearn.preprocessing as preprocess


# 熵权法
# @param index_data 基本数据
# @param direction_index 指标正向负向说明
# @param scaler 标准化object

def ent_weight(index_data, direction_index, scaler, use_dir=True):
    data_index_columns = index_data.columns
    c_data = scaler.fit_transform(index_data)
    scaler_data = pd.DataFrame(c_data)
    scaler_data.columns = data_index_columns
    # 使用指标选取和 {正向 反向} 处理
    if use_dir:
        columns_selection = list(direction_index.keys())
        current_data = index_data[columns_selection].copy()
        for item in columns_selection:
            if not direction_index[item]:
                current_data[item] = - current_data[item]
        c_data = scaler.fit_transform(current_data)
        scaler_data = pd.DataFrame(c_data)
        scaler_data.columns = columns_selection
    calcu_columns = scaler_data.columns
    # 计算指标比重
    k = 1.0 / np.log(scaler_data.shape[0])
    columns_entropy_diff = {}
    for i in calcu_columns:
        scaler_data[i] = scaler_data[i] / scaler_data[i].sum()
        current_columns = scaler_data[scaler_data[i] > 0][i]
        # 信息熵冗余度
        columns_entropy_diff[i] = 1.0 + k * sum(current_columns * np.log(current_columns))
    total_value = sum(columns_entropy_diff.values())
    columns_weight = {}
    for i, value in columns_entropy_diff.items():
        columns_weight[i] = value / total_value
    scaler_data['entropy_weight'] = 0
    for i in calcu_columns:
        scaler_data['entropy_weight'] = scaler_data['entropy_weight'] + scaler_data[i] * columns_weight[i]
    return scaler_data['entropy_weight']


data = pd.DataFrame({'a': [1, 2, 3, 4], 'b': [2, 4, 1, 5]})
direction_index = {'a': True, 'b': False}
scaler = preprocess.MinMaxScaler()
data['entropy_weight'] = ent_weight(data, direction_index, scaler)
print(data['entropy_weight'])