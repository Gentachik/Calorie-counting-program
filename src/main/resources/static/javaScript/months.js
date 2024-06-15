// Get current date
const currentDate = new Date();

// Get current month and year
const currentMonth = currentDate.getMonth();
const currentYear = currentDate.getFullYear();

// Get number of days in current month
const daysInMonth = new Date(currentYear, currentMonth + 1, 0).getDate();

// Display days in HTML
const daysOfMonthElement = document.getElementById('daysOfMonth');
daysOfMonthElement.innerHTML = `<p>Current Month: ${currentMonth + 1}</p>`;

const daysList = document.createElement('ul');
for (let day = 1; day <= daysInMonth; day++) {
    const listItem = document.createElement('li');
    const link = document.createElement('a');
    link.href = `day/${currentMonth + 1}/${day}/${currentYear}`;
    link.textContent = `${currentMonth + 1}/${day}/${currentYear}`;
    listItem.appendChild(link);
    daysList.appendChild(listItem);
}

daysOfMonthElement.appendChild(daysList);