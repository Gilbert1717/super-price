# RMIT COSC2299 SEPT Major Project

# Group Information

## Group-P7-06

## Members
* Edward (Ned) Pearson (s3844470)
* Rita Lam Cordeiro (s3947881)
* Yash Dhukate (s3898134)
* James Czeredys (s3900781)
* Yiqi (Gilbert) Du (s3665887)
* Raphael Bullen (s3897844)

## Links to videos
Yiqi (Gilbert) Du: https://rmiteduau-my.sharepoint.com/:v:/r/personal/s3665887_student_rmit_edu_au/Documents/GROUP-P7-06%20Yiqi%20Du%20COSC2299-23s2%20Milestone%203.webm?csf=1&web=1&e=OljjWx&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZyIsInJlZmVycmFsQXBwUGxhdGZvcm0iOiJXZWIiLCJyZWZlcnJhbE1vZGUiOiJ2aWV3In19
Links to individual videos found in docs/Milestone3/SRS_Group_06_Milestone3.docx in the Appendix: Milestone 3 section

## Records

* Github repository: https://github.com/cosc2299-sept-2023/team-project-group-p07-06.git
* Github Project Board : https://github.com/orgs/cosc2299-sept-2023/projects/62/views/1

	
## Milestone 3 Features - 17 September 2023
* Added shopping cart 
* Added more items (specifically groceries) to database 
* Popup notification for special offers 
* Added payment checkout (Custom Feature) 
* Can view orders (Custom Feature) 
  

# Run Instructions
How to run our project.

### Setup your environment 
You will need to have in your system

- Java 17.0 or higher
- Node and npm
- Apache Maven
- IDE or Editor

### How to run:
#### With h2 database:
In root of project, run:
`docker-compose up`

#### With MySQL database:
In root of project, run:
`docker-compose -f docker-compose-mysql.yml --env-file compose-vars.env up`
