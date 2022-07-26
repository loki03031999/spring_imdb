Problems Encountered 

PostRequest for testingPurpose 
curl -X POST -H "Content-Type: application/json" -d "{""titleName"": ""Avengers Endgame""}"  http://localhost:8081/title/save


Day 2 - 
1. Persisting genre bean in database had some issues - reasons for this is I was setting Id of genreEntity using setId setter method. This gave error ": detached entity passed to persist:".

Day 3 - 
1. In TitleDAO got error compiler was not able to initialize titleDAO object - reason manually instantiated EntityManager object so bean was not created 