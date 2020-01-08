const init = () => {
    let input = document.querySelector("#inputText");

    // Calls the getGiphyData whenever a key is let up
    input.addEventListener("keyup", event => {
        getGiphyData();
      });
}

const getGiphyData = async () => {
    // Your API key to giphy.com
    const api = "xTvzO93WAYQ67BvIOIu2rHYHhzs6WcKj";

    // Choose how many images you want to be retrieved
    const limit = 10;

    let input = document.querySelector("#inputText").value;
    const url = `http://api.giphy.com/v1/gifs/search?limit=${limit}&api_key=${api}&q=${input}`;

    await fetch(url).then(data => data.json()).then(jsonData => {
        let output = document.querySelector(".main");
        let input = document.querySelector("#inputText");

        output.innerHTML = "";

        const singleImage = jsonData.data.map(eachImage => {
            let div = document.createElement("div");
            let image = document.createElement("img");
            image.classList.add("image");
            image.src = eachImage.images.downsized.url;
            div.appendChild(image);
            output.appendChild(div);
        })
    });
}

window.onload = init;
