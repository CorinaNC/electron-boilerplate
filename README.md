This is where the wrist began
=============================

## 1. ML:
Go to `ml` folder.

### 1. Install Dependencies:
```aiignore
pip3 install -r requirements.txt
```

## 2. Java Backend:
Go to `backend` folder.
### 1. Set up MongoDB:
- Go into `src/main/resources` folder.
- Add a `secrets.properties` file with your MongoDB's URI following `secrets.properties.example` format.

### 2. Install and Compile:
```aiignore
mvn clean install
```
or
```aiignore
mvn clean install -DskipTests
```
### 3. Test:
```aiignore
mvn test
```

