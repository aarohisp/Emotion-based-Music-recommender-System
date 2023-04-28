# Emotion-Based Music Recommender System
This project is an emotion-based music recommender system that recommends songs based on the user's emotional state. It uses machine learning algorithms to analyze the user's emotions and suggests songs that match their emotional state.

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites
The following libraries are required to run the project:

- tensorflow
- keras
- pandas
- numpy
- matplotlib

### Installing
To install the required libraries, run the following command:
  - pip install tensorflow keras pandas numpy matplotlib

### Dataset
The dataset used for this project is the Last.fm subset dataset. features we used from the dataset include data on songs, artists, and user tags. 

## Model
The model used in this project is a Recurrent Neural Network(RNN) model that consists of an embedding layer, an LSTM layer, and a dense layer. The model was trained on the Last.fm subset dataset using the binary cross-entropy loss function and the RMSprop optimizer.

## Running the project
To run the project, follow the steps below:

- Clone the project repository.
- Download and extract the Last.fm subset dataset.
- Open the "emotion-based-music-recommender-system.ipynb" file in Jupyter Notebook.
- Run the code cells in the notebook.

## Results
The model was able to accurately predict the user's emotional state and recommend songs that matched their emotional state. The training and validation loss and accuracy were plotted to show the performance of the model.

## Built With
- Python
- TensorFlow
- Keras
- Pandas
- NumPy
- Matplotlib

## Contributors
This project was developed by a team of students from Symbiosis Institute of Technology, Pune.
