# Mobilize! Hackathon
**Preso:** https://docs.google.com/presentation/d/1qjmtuTJyQA3aU0MyAHr-HMhOfAIqGYofzYe0DcssEhk/edit#slide=id.p

**What:** AMP-up (?) - music learning app. A “piazza for music” where snippets of music can be posted and users can discuss, play, compare and ask about them. Social, collaborative, cloud-based, crowdsourced instrument learning app.

**Before we begin:**
- “Us winning this hackathon” is not:
- impossible
- easy
- a refrigirator
- Jackie Chan
**“Us winning this hackathon” is:**
- what people who travel back in time would call “fact”
- an inevitability of fate
- entirely up to us and our attitude
- Jackie Chan

Things we will need:
- User accounts
  - support students and instructors
  - later, also support “artists” (?)
- Server that stores and manages:
  - discussion topics
  - sound files
  - images
  - user-data
  - additional information(?)
- User Interface/Experience (at the final form of the app)
  - smooth (demo-able) experience
  - tags and labels on questions (like piazza) for easy searching
  - differentiate student and instructor accounts
    - (do this by having two different layouts for the same activity? two activities for the same layout? completely separate?)
    - students can: submit audio to instructors, post questions, suggest answers, suggest their recorded “version” of an exercise, post images (sheet music snippets)
    - instructors can: submit a “verified solution” to a question, endorse a student solution, post answers, discuss student answers, post exercises (and assign them), post announcements, post images (sheet music snippets, maybe even their own hand-written/printed exercises)
  - Tie-in with the nonprofit
    - loading and uploading screens could have a blurb about AMP, while users wait for the app
      - quick links to open facebook page/website
      - maybe a donation button
    - add a “news” and “about” tabs to the app that talk about AMP
- Extra features and scenarios we would like to talk about as “directions the app can take after the hackathon” or mock-up for the demo
  - remote teaching with teachers from all over the world
    - teachers can even record and send snippets of music to the student comment on the student’s playing ability
  - can be a way to distribute a set of exercises to a class
  - can be made into a global “learning forum” where exercise-sets are provided and the community can assist new players
  - artists can “donate” exercises and their own recording (maybe allow them to include an audio description of the exercise or just let them post flavor-text) which could be sold for a small fee (really small, maybe $1 for a small set, $5 for something more substantial) and users could buy these and the money is donated to AMP
  - talk about how more advanced features of the device might be used with the app
    - NFC to quickly point another student (or an instructor) to a specific exercise or solution
    - tie in to android’s “share” service
    - better note detection feature to analyze playing ability
    - read notes off of images (like OCR)
    - add a tuner and a metronome
    - vidhur vidhur vidhur
- Technical features
  - server:
    - node restful API
    - mongo database
    - files are stored on the computer
    - server needs to accept POST with attached music/image files
    - “authenticate” users
    - deliver JSON information and files for specific “views”
      - all questions in a “classroom”
      - all comments/solutions to a question
      - etc.
  - client
    - android >=4.0.x
    - smooth UI and UX (see above)
    - store some data locally (don’t request all the questions every time you go to the main view, keep them in a local database and update db and view when you query for new questions)
    - Use camera and microphone; produce useable sound and image files; send them to server.
    - eat pineapples
    - jarvis should fill out the rest...
  - vidhur
    - vidhur vidhur vidhur vidhur
    - vidhur vidhur
    - vidhur vidhur vidhur
    - vidhur

**Versions and Agile approach**
- v0.0 - basic contact and views
  - log-in screen
  - loading screen
  - classroom lobby
  - contact simple server for log-in (plain-text authentication
  - receive array of (empty) questions from server, display an empty list as the lobby
  - contact db on server
- v0.1 - text based adventure
  - create a view for displaying individual questions and answers
    - separate student and instructor answer
  - client should store data from the server so it’s faster to load the lobby every time
  - questions should only have a text-field as their “question body”
  - answers can be displayed
  - separate student and instructor answers on the page
  - server sends “fake” questions and answers
- v0.2 - shouldn’t we also be able to post questions
  - client implements POST requests to create new questions
  - server supports POST requests to create new questions
    - no longer sends fake questions to the view
  - create a view for submitting questions (forms)
  - similar POST for submitting answers
- v0.3 - what about the music
  - client can attach images to questions
    - load from sdcard
    - take pictures
  - server can receive images for questions
    - store locally
    - db stores the string containing the path to the file
  - client can attach audio to answers
    - load from sdcard
    - record (don’t worry about setting up tempo/signature yet, but leave adequate room for it to be implemented later)
  - server stores and sends audio files
- v0.4 - collaborate/rate
  - instructors can endorse student answers
  - add comments to answers (use as follow-up discussion)
  - up-vote/down-vote questions 
  - up-vote/down-vote student-answers
- v0.5 - ORGANIZE!
  - map all question based on #-tags found in the question body and answers
    - maybe we should be careful, since the octothorpe is often used for sharp-notes (e.g. C#, F#, etc.)
  - implement tag-search
    - screw full-text search.
  - filter the standard lobby view to only show posts for the relevant tag
  - server needs to support tags on questions
- >=v0.6 - tba when we talk about it/get closer
  - vidur vidur vidur
