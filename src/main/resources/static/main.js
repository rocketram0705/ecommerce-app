//populate userData table on load
window.addEventListener('load',populateUserListTable);
//clear all fields
function clearallfields(){
    document.getElementById("name").value="";
    document.getElementById("father-name").value="";
    document.getElementById("dateOfBirth").value="";
    document.getElementById("address").value="";
}
// get data from the fields
function savedata(){
    const names = document.getElementById("name").value;
    const fathername = document.getElementById("father-name").value;
    const dateOfBirth = document.getElementById("dateOfBirth").value;
    const address = document.getElementById("address").value;
    if ( names=="" || fathername=="" || dateOfBirth=="" || address==""){
        alert("please all fields.....");
    }
    else{
            alert("you entered inside");
            var requestParameter = JSON.parse("{}");
            requestParameter["username"] = names;
            requestParameter["fname"] = fathername;
            requestParameter["dob"]=dateOfBirth;
            requestParameter["addressOfUser"]=address;
            requestParameter["password"] ="root";
            let url = 'http://localhost:8080/registeruser';
            const request = fetch(url,{
                method:'POST',
                body:JSON.stringify(requestParameter),
                headers:{
                    'Content-type':'application/json'
                }
            }).then((response)=>{
                return response.text();
            }).then((data)=>{
                alert(data);
            }).then(()=>{
                populateUserListTable();
            }
            );
    }
} 

function  populateUserListTable(){
    let url = 'http://localhost:8080/getallusers';
    fetch(url).then((response)=>{return response.json()}).then((data)=>{
        console.log(data);
        const listcontainer = document.getElementById("datalist");
        listcontainer.innerHTML ="";
         for(var obj in data){
            const datacontainer = document.createElement("div");
            datacontainer.setAttribute('class','datacont');
            listcontainer.appendChild(datacontainer);
            let cancelButton = document.createElement("button");
                cancelButton.className="deleteButtonCls";
               cancelButton.setAttribute('onclick','deleteItemFromList(event)');
                datacontainer.appendChild(cancelButton);
            for (var item in data[obj]){
                let dataElement = document.createElement("label");
                dataElement.innerHTML = data[obj][item];
                datacontainer.appendChild(dataElement);
            }
        }
        clearallfields();
    });
}

/*const deleteButtonList=document.getElementsByClassName('deleteButtonCls');
for(let i=0;i<deleteButtonList.length;i++){
    deleteButtonList[i].addEventListener('click'*/


function deleteItemFromList(event){
    deleteButton = event.target;
    let sno = deleteButton.nextElementSibling.innerHTML;
    let delURL = `http://localhost:8080/deleteUser/?id=${sno}`;
    const delReq = fetch(delURL,{
        method:'DELETE',
        headers:{
            'Content-type':'application/json'
        }
    }).then((response));
};
