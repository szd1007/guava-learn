import pandas as pd
from sklearn.ensemble import RandomForestClassifier
from sklearn.model_selection import train_test_split
from sklearn.metrics import classification_report, accuracy_score

training_data = pd.read_parquet("/Users/zm/aigcData/toutiao-text-classfication-dataset/toutiao_cat_data_all_with_embeddings.parquet")
training_data.head()

df = training_data.sample(50000, random_state=42)

X_train, X_test, y_train, y_test = train_test_split(list(df.embedding.values),
                                                    df.category, test_size=0.2, random_state=42)
clf = RandomForestClassifier(n_estimators=300)
clf.fit(X_train, y_train)
preds = clf.predict(X_test)
probas = clf.predict_proba(X_test)

report = classification_report(y_test, preds)
print(report)