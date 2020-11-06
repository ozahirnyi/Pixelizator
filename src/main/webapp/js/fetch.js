const url = 'http://localhost:8080/upload';
const data = { username: 'example' };

document.getElementById("applyButton").addEventListener('click', async function () {
    try {
        const response = await fetch(url, {
            method: 'POST', // или 'PUT'
            body: JSON.stringify(data), // данные могут быть 'строкой' или {объектом}!
            headers: {
                'Content-Type': 'application/json'
            }
        });
        alert("YA EBU11")
        const json = await response.json();
        console.log('Ne Zhopa', json);
    } catch (error) {
        console.error('Zhopa', error);
    }
});