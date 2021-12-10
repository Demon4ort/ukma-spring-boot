let data;
let getedLessons = [];
let enrolleddLessons = [];
let temp;
let placeForData = $("#data");
let enrolledData = $("#enrolled")
function download(filename, text) {
    var element = document.createElement('a');
    element.setAttribute('href', 'data:text/plain;charset=utf-8,' + encodeURIComponent(text));
    element.setAttribute('download', filename);
  
    element.style.display = 'none';
    document.body.appendChild(element);
  
    element.click();
  
    document.body.removeChild(element);
  }
URL = 'http://localhost:8080/lessons/lessons';
const makeRequest = () => {
    $.ajax({
        url: URL, method: "GET", success: function (result) {
            console.log(result);
            placeForData.empty();
            result.forEach(function(item, counter){
                temp = {
                    lessonId : item.lessonId,
                    courseName: item.courseName,
                    teacher: item.teacher,
                    day: item.day,
                    time : item.time,
                    year: item.year,
                    groupNumber : item.groupNumber
                };
                getedLessons.push(temp); 
                console.log(getedLessons);
                placeForData.append(`
            <div class="container-fluid" id="data">
                <div class="card" id="lesson${item.lessonId}">
                    <div class="card-header bg-veryDB border-2">
                      <h3 class="font-lBrwn"><a id="courseName">${item.courseName}</a></h3> 
                    </div>
                    <div class="card-body bg-brwn">
                      <h5 class="card-title"><a id="teacher">${item.teacher}</a></h5>
                        <ul>
                          <li>Day of week: <a id="day">${item.day}</a></li>
                          <li>Number of lesson: <a id="time">${item.time}</a></li>
                          <li>Year: <a id="year">${item.year}</a></li>
                          <li>Group: <a id="groupNumber">${item.groupNumber}</a></li>  
                        </ul>
                      <button id="action${item.lessonId}" class="btn bg-db">Enroll</button>
                    </div>
                </div>
            </div>`)
            $('#action'+item.lessonId).on('click', () =>{
                enrolleddLessons.push({
                    lessonId : item.lessonId,
                    courseName: item.courseName,
                    teacher: item.teacher,
                    day: item.day,
                    time : item.time,
                    year: item.year,
                    groupNumber : item.groupNumber
                })
                $('#lesson'+item.lessonId).empty();
                console.log("enrolled");
                console.log(enrolleddLessons);
                enrolledData.empty();
                enrolleddLessons.forEach( (item, counter) => {
                    enrolledData.append(`
                        <div class="container-fluid" id="data">
                            <div class="card" id="lesson${item.lessonId}">
                                <div class="card-header bg-veryDB border-2">
                                <h3 class="font-lBrwn"><a id="courseName">${item.courseName}</a></h3> 
                                </div>
                                <div class="card-body bg-brwn">
                                <h5 class="card-title"><a id="teacher">${item.teacher}</a></h5>
                                    <ul>
                                    <li>Day of week: <a id="day">${item.day}</a></li>
                                    <li>Number of lesson: <a id="time">${item.time}</a></li>
                                    <li>Year: <a id="year">${item.year}</a></li>
                                    <li>Group: <a id="groupNumber">${item.groupNumber}</a></li>  
                                    </ul>

                                </div>
                            </div>
                        </div>`)  
                })

            })   
            })         
        }
    })
}
makeRequest();

$("#print").on('click', () => {
    // console.log("Now enrolled");
    // console.log(enrolleddLessons);
    const items = enrolleddLessons
    const replacer = (key, value) => value === null ? '' : value // specify how you want to handle null values here
    const header = Object.keys(items[0])
    const csv = [
  header.join(','), // header row first
  ...items.map(row => header.map(fieldName => JSON.stringify(row[fieldName], replacer)).join(','))
].join('\r\n')

console.log(csv)
download("Schedule", csv);
})