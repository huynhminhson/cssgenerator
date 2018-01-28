# cssgenerator
CLI tool to quickly generate CSS structure for HTML components.


## Status
![Travis CI](https://api.travis-ci.org/huynhminhson/cssgenerator.svg?branch=master)


## Getting Started
### Prerequisites
* JRE 8
* Maven 


### Installing
* Clone this repository and find in the **target** folder a compiled jar file.


## Running the tests
```
mvn test 
```


## Usage 
```
$ java -jar target/cssgenerator-1.0-SNAPSHOT-jar-with-dependencies.jar sample.html
```


## Examples
### sample.html
```html
<div class="c-card">
  <div class="header">
    <div class="title"></div>
  </div>
  <div class="body">
    <div class="img"><img src="" alt=""></div>
    <div class="content"></div>
  </div>
  <div class="footer">
    <div class="text"></div>
    <div class="button"></div>
  </div>
</div>
```


### Generated CSS 
```css
.c-card {}
.c-card > .header {}
.c-card > .header > .title {}
.c-card > .body {}
.c-card > .body > .img {}
.c-card > .body > .img > img {}
.c-card > .body > .content {}
.c-card > .footer {}
.c-card > .footer > .text {}
.c-card > .footer > .button {}
```

### Screenshots 
![cssgenerator](https://raw.githubusercontent.com/huynhminhson/cssgenerator/master/screenshot.png)


## Built With
* [jsoup](https://jsoup.org/) - Java HTML Parser
* [Maven](https://maven.apache.org/) - Build Tool


## Authors
* **Minh Son Huynh** - [Minh Son Huynh](https://github.com/huynhminhson)


## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details
