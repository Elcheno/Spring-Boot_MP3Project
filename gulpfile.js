const {src, dest, series, parallel} = require('gulp');
const sass = require('gulp-sass')(require('sass'));
const sassdoc = require('sassdoc');


function build_css() {
    return src("src/main/resources/static/sass/style.scss")
        .pipe(sass())
        .pipe(dest("src/main/resources/static/css/"));
}

function build_sass_doc(){
    return src("src/main/resources/static/sass/*.scss")
        .pipe(sassdoc());
        // .pipe(dest("docs"));
}

exports.build_css = build_css;
exports.build_sass_doc = build_sass_doc;
exports.default = series(build_css(), build_sass_doc());