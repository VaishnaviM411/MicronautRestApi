# MicronautRestApi

## Set up:
  - Clone this repository: 
  
    `git clone https://github.com/VaishnaviM411/MicronautRestApi.git`
    
  - Run the gradlew executable file using `./gradlew run` to start the server


## Making requests:

- Make a post request to http://localhost:8080/text/analyze

- Sample request body

  { "content": "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum." }

- Sample response

  { "word_count": 91, 
    
    "character_count_with_spaces": 574, 
    
    "character_count_without_space": 484,  
    
    "line_count": 4, 
    
    "unique_words": 66 }
