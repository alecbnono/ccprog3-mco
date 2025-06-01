# JavaJeeps: Coffee Truck Business Simulation

☕ _Mobile Coffee Vendor Simulation_ | 🚚 _OOP Design Project_

## 📌 Project Overview

**JavaJeeps** simulates a mobile coffee truck business inspired by Filipino "Jolli-jeeps". This Java application models:

- **Regular Trucks (JavaJeep)** - Basic coffee service
- **Special Trucks (JavaJeep+)** - Custom drinks with extra features

**Key Features:**  
✅ Strategic location deployment  
✅ Real-time inventory tracking  
✅ Sales transaction processing  
✅ Business analytics dashboard

## How to use

### Clone Repository

```
git clone https://github.com/alecbnono/ccprog3-mco.git
```

### Compile and run (Java 17+ required)

```
cd ccprog3-mco
javac -d bin src/*.java src/view/*.java src/model/*.java src/controller/*.java
java -cp bin Driver
```

## Project organization

The MVC structure is in `src` folder. In it, there are three folders and one files.

### / (root)

| Name           | Type        | Function                        |
| -------------- | ----------- | ------------------------------- |
| bin            | `Directory` | Binary files (&#46;class files) |
| src            | `Directory` | MVC framework                   |
| &#46;gitignore | `File`      | Github generated file           |

### /src

| Name            | Type        | Function                                       |
| --------------- | ----------- | ---------------------------------------------- |
| assets          | `Directory` | Contains all application content files         |
| controller      | `Directory` | Contains all application controller classes    |
| model           | `Directory` | Contains all application model classes         |
| view            | `Directory` | Contains all application view classes          |
| Driver&#46;java | `File`      | Class responsible for starting the application |
