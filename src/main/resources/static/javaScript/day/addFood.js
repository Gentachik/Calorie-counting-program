'use strict';

const form = document.querySelector('.search');
const results = document.querySelector('.results');

const getQuery = function () {
    const query = form.querySelector('.search__field').value;
    form.querySelector('.search__field').value = '';
    return query;
}

const loadSearchResults = async function (query) {
    const res = await fetch(`http://localhost:8080/api/food?search=${query}`);
    return res.json();
}

const getDateParam = function () {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get('date');
}

const searchResults = async function () {
    const query = getQuery();
    const date = getDateParam();
    results.innerHTML = '';
    const data = await loadSearchResults(query);
    if (data.length === 0) {
        results.insertAdjacentHTML('afterbegin', `<li>No food for '${query}' were found</li>`);
        return;
    }
    data.forEach(food => {
        results.insertAdjacentHTML('afterbegin', `<li className="food">
                    <a className="preview__link" href="http://localhost:8080/day/add-food/${food.id}?date=${date}">  
                        <div className="preview__data">
                            <h4 className="preview__name">${food.name}</h4>
                            <h6>${food.calorie}</h6> 
                            <h6>${food.protein}</h6> 
                            <h6>${food.fat}</h6> 
                            <h6>${food.carbohydrate}</h6> 
                        </div>
                    </a>
                </li>`);
    });
}

const getResults = async function () {
    form.addEventListener('submit', function (e) {
        e.preventDefault();
        searchResults();
    })
}

getResults();