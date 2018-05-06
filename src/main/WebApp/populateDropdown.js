$(document).ready(function() {
    $.ajax({
    url: "localhost:8080/getAllVillages"
}).then(function(data) {
    $.each(data, function (key, entry) {
        $(.'menulist').append("<button type=\"button\" class=\"btn btn-primary\">" + .append(data.name) + "</button>");
    })
});
});