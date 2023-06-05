const {src, dest, series, start} = require('gulp');
const sass = require('gulp-sass')(require('sass'));
const sassdoc = require('sassdoc');
const run = require('gulp-run');
const watch = require('gulp-watch');



function build_style() {
    return src("src/main/resources/static/sass/style.scss")
        .pipe(sass())
        .pipe(dest("src/main/resources/static/css/"));
}

function build_style_watch() {
    build_style();
    return watch("src/main/resources/static/sass/*.scss", function () {
        build_style();
    });
}

function build_style_doc() {
    var options = {
        dest: 'docs/sassdoc'
    }
    return src('src/main/resources/static/sass/*.scss')
        .pipe(sassdoc(options));
}

function run_project() {
    return run("mvnw spring-boot:run").exec();
}




exports.build_style = build_style;
exports.build_style_watch = build_style_watch;
exports.build_style_doc = build_style_doc;
exports.run = run_project;
exports.default = series(build_style, run_project);
