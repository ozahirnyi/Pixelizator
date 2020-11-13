function readURL(input) {
    if (input.files && input.files[0]) {
        // document.getElementById("name").textContent = `name: ${input.files[0].name}`;
        // document.getElementById("size").textContent = `size: ${(input.files[0].size / 1000 / 1000).toString().slice(0, (input.files[0].size / 1000 / 1000).toString().indexOf('.') + 3)}MB`;
        // document.getElementById("format").textContent = `format: ${input.files[0].type}`
        document.getElementById("forOutput").src = '';
        document.getElementById("forOutput").style.display = 'none';
        let reader = new FileReader();
        reader.onloadend = function (e) {
            let img = document.getElementById("forInput");
            img.src = reader.result;
            img.style.display = 'block'
        };
        reader.readAsDataURL(input.files[0]);
    } else {
        // document.getElementById("name").textContent = '';
        // document.getElementById("size").textContent = '';
        // document.getElementById("format").textContent = '';
        document.getElementById("forOutput").src = '';
        document.getElementById("forOutput").style.display = 'none';
        document.getElementById("forInput").src = '';
        document.getElementById("forInput").style.display = 'none';
    }
}