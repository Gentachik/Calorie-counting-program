const currentDate = new Date();

const currentMonth = currentDate.getMonth();
const currentYear = currentDate.getFullYear();
const currentDay = currentDate.getDate();

const daysInMonth = new Date(currentYear, currentMonth + 1, 0).getDate();

const daysOfMonthElement = document.getElementById('daysOfMonth');
daysOfMonthElement.innerHTML = `<p>Current Month: ${currentMonth + 1}</p>`;

const daysList = document.createElement('ul');
for (let day = 1; day <= daysInMonth; day++) {
    if (day <= currentDay) {
        const listItem = document.createElement('li');
        const link = document.createElement('a');
        const formattedDate = `${currentMonth + 1}/${day}/${currentYear}`;
        link.href = `day/day?date=${formattedDate}`;
        link.textContent = formattedDate;
        listItem.appendChild(link);
        daysList.appendChild(listItem);
    }
}

daysOfMonthElement.appendChild(daysList);