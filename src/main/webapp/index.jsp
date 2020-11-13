<html>
<link rel="stylesheet" href="cssPage.css">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Pixeliz Det Shit Plz</title>
</head>

<body>
    <h1>Poisk Mnogo CHLENOV|3======D</h1>
        <div>
            <h3> Choose File to Upload in Server </h3>
            <label class="forformelem " name="UPLOAD" for="fileUploader">Choose images to upload (PNG, JPG)</label>
            <input type="file" value="upload" id="fileUploader" name="file" accept=".jpg, .jpeg, .png" width="500" height="600" onchange="updateImageDisplay">
            <button id="applyButton">SuckMaBolz</button>
        </div>
        <br>
        <div class="mainDiv">
            <div class="contentImg">
                <img class="im" id="forInput" src="images/ozahirnyi.png" alt="imageInput">
                <img class="im" id="forOutput" src="images/ozahirnyi.png" alt="imageOutput">
            </div>
        </div>
    <script src="js/fetch.js"></script>
</body>
</html>
