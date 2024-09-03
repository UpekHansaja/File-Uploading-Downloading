function uploadFile() {
    
    const email = document.getElementById("email").value;
    const file = document.getElementById("file1").files[0];
    
//    console.log(email);
//    console.log(file1);
    
    const data = new FormData();
    data.append("email", email);
    data.append("file", file);
    
    const response = fetch("Uploading", {
        method: "POST",
        body: data,
    });
    
    if (response.ok) {
        console.log("Success");
    } else {
        console.log("Error");
    }
    
}