import pandas as pd
import numpy as np
from sklearn.tree import DecisionTreeClassifier
from sklearn.model_selection import train_test_split 
from sklearn.metrics import accuracy_score  
from sklearn.preprocessing import LabelEncoder
#from IPython.display import Image  
from sklearn import tree
#import pydotplus
import matplotlib.pyplot as plt

X = pd.read_csv('Dataset.csv')
X = X.drop(columns="ID")
Y = X["Buys"]
X = X.drop(columns="Buys")

le = LabelEncoder()
X["Marital Status"] = le.fit_transform(X["Marital Status"])
X["Gender"] = le.fit_transform(X["Gender"])
X["Income"] = le.fit_transform(X["Income"])
X["Age"] = le.fit_transform(X["Age"])
print(X)

train_X, test_X, train_Y, test_Y = train_test_split(X, Y, test_size=0.30, shuffle= False)

classifier = DecisionTreeClassifier(criterion = 'entropy', max_depth = 4)
classifier.fit(train_X, train_Y)
y_predicted = classifier.predict(test_X)
# accuracy = accuracy_score(y_predicted, test_Y)
# print("Accuracy: ", accuracy)

tree.export_graphviz(classifier,out_file='tree.dot')
tree.plot_tree(classifier, feature_names = ['Age', 'Income', 'Gender', 'Marital Status'], 
                     class_names=['Yes','No'],
                     filled = True)  
plt.savefig('tree.png')

#Prediction
test = np.array([1,1,1,0])
test = test.reshape(1,-1)
res = classifier.predict(test)
print("Prediction: ", res)
