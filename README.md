![Travis CI](https://api.travis-ci.org/huynhminhson/cssgenerator.svg?branch=master)

## Usage 
```
$ java -jar cssgenerator-1.0-SNAPSHOT-jar-with-dependencies.jar "your-component.html"
```

## Examples
### your-component.html
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
