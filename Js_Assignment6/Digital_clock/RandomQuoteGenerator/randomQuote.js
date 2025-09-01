const quoteText = document.getElementById('quoteText');
const newQuoteBtn = document.getElementById('newQuoteBtn');

const quotes = [
    {
        quote: "Forgiveness is the power to choose how things affect you."
    },
    {
        quote: "Fear is wisdom as a child."
    },
    {
        quote: "Every wound offers us a gift."
    },
    {
        quote: "Whatever the mind of man can conceive and believe, it can achieve."
    },
    {
        quote: "It is never too late to be what you might have been."
    },
    {
        quote: "If you can dream it, you can achieve it."
    },
    {
        quote: "The only way to do great work is to love what you do."
    },
    {
        quote: "Dreaming, after all, is a form of planning."
    }
];

function getRandomQuote() {
    const randomIndex = Math.floor(Math.random() * quotes.length);
    const randomQuote = quotes[randomIndex];
    quoteText.textContent = `"${randomQuote.quote}"`;
    
}

newQuoteBtn.addEventListener('click', getRandomQuote);

getRandomQuote();