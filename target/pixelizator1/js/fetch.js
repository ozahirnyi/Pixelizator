const url = 'http://localhost:8080/upload';
var imgOut = document.getElementById("forOutput")

document.getElementById("applyButton").addEventListener('click', async function () {
    const formData = new FormData();
    const fileField = document.querySelector('input[type="file"]');

    formData.append("file", fileField.files[0]);
    try {
        let response = await fetch(url, {
            method: 'POST',
            body: formData,
            enctype: "multipart/form-data"
        });
        if (response.ok) {
            alert("YA EBU11")
            const json = await response.json();
            console.log('Ne Zhopa', json);
            imgOut.src = "data:image/png;base64," + response.imageForOutput;
        }
    }
    catch (error) {
        console.error('Ya ebu', error);
    }
});