const cookieArr = document.cookie.split("=")
const userId = cookieArr[1]

const songContainer = document.getElementById("song-container")
const getSongsBtn = document.getElementById("get-all-songs")
const getFavoritesBtn = document.getElementById("get-favorites")

const headers = {
    'Content-Type':'application/json'
}

const baseUrl = 'http://localhost:8090/api/v1/songs'

function handleLogout(){
    let c = document.cookie.split(";")
    for (let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}

async function  getSongs(){
    await fetch(`${baseUrl}/songs`, {
        method: "GET",
        headers:headers
    })
        .then(res => res.json())
        .then(data => createSongCard(data))
        .catch(err => console.log(err))
}

async function handleFavorites(obj) {
    const response = await fetch(`${baseUrl}/favorite/${userId}`, {
        method: "POST",
        body: JSON.stringify(obj),
        headers: headers
    })
        .catch(err => console.error(err.message))
    if (response.status === 200){
        alert("Added to favorites")
    }

}

async function getFavorites(){
    await fetch(`${baseUrl}/favorite/get/${userId}`, {
        method: "GET",
        headers: headers
    })
        .then(res => res.json())
        .then(data => createFavoriteSongCard(data))
        .catch(err => console.log(err.message))
}

const createSongCard = (array) => {
    songContainer.innerHTML = ''
    array.forEach(obj => {
        let songCard = document.createElement("div")
        songCard.classList.add("m-2")
        songCard.innerHTML = `
        <div class="col">
            <div class="card border-primary mb-3 d-flex card-shadow" style="width: 18rem; height: 18rem;">
                <div class="card-body d-flex flex-column justify-content-between" style="height: available">
                    <h5 class="card-title">${obj.name}</h5>
                    <p class="card-text">${obj.band}</p>
                    <p class="card-text">${obj.album}</p>
                    <p class="card-text">${obj.length}</p>
                    <div class="d-flex justify-content-between">
                    <button class="btn btn-primary" onclick="handleFavorites(${obj.id})">Favorite</button>
                    </div>
                </div>
            </div>
        </div>`
        songContainer.append(songCard)
    })
}

async function handleDelete(obj){
    await fetch(`${baseUrl}/favorite/delete/${userId}`, {
        method: "DELETE",
        body: JSON.stringify(obj),
        headers: headers
    })
        .catch(err => console.error(err.message))

    return getFavorites()
}

const createFavoriteSongCard = (array) => {
    songContainer.innerHTML = ''
    array.forEach(obj => {
        let songCard = document.createElement("div")
        songCard.classList.add("m-2")
        songCard.innerHTML = `
        <div class="col">
            <div class="card border-danger mb-3 d-flex" style="width: 18rem; height: 18rem;">
                <div class="card-body d-flex flex-column justify-content-between" style="height: available">
                    <h5 class="card-title">${obj.name}</h5>
                    <p class="card-text">${obj.band}</p>
                    <p class="card-text">${obj.album}</p>
                    <p class="card-text">${obj.length}</p>
                    <div class="d-flex justify-content-between">
                    <button class="btn btn-danger" onclick="handleDelete(${obj.id})">Delete</button>
                    </div>
                </div>
            </div>
        </div>`
        songContainer.append(songCard)
    })
}

getSongsBtn.addEventListener("click", getSongs)
getFavoritesBtn.addEventListener("click", getFavorites)

