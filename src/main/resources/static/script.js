// Array of search suggestions
var searchSuggestions = [
  "Apple",
  "Banana",
  "Orange",
  "Mango",
  "Lemon"
];

// Get the search input field and results container
var searchInput = document.getElementById("search-input");
var searchResults = document.getElementById("search-results");

// Function to display search results
function showResults() {
  // Get the user's search query
  var query = searchInput.value.toLowerCase();

  // Clear the search results container
  searchResults.innerHTML = "";

  // Loop through the search suggestions and find matches
  for (var i = 0; i < searchSuggestions.length; i++) {
    // Check if the search suggestion matches the query
    if (searchSuggestions[i].toLowerCase().indexOf(query) !== -1) {
      // Create a link for the search suggestion
      var link = document.createElement("a");
      link.setAttribute("href", "#");
      link.textContent = searchSuggestions[i];

      // Add the link to the search results container
      searchResults.appendChild(link);

      // Show the search results container
      searchResults.style.display = "block";
    }
  }

  // Hide the search results container if there are no results
  if (searchResults.innerHTML === "") {
    searchResults.style.display = "none";
  }
}

// Add event listeners for the search input field
searchInput.addEventListener("input", showResults);
searchInput.addEventListener("focus", showResults);
searchInput.addEventListener("blur", function() {
  setTimeout(function() {
    searchResults.style.display = "none";
  }, 200);
});

// Add event listeners for the search result links
searchResults.addEventListener("click", function(event) {
  // Prevent the link from navigating
  event.preventDefault();

  // Set the search input field value to the clicked link
  searchInput.value = event.target.textContent;

  // Hide the search results container
  searchResults.style.display = "none";
});


/*


// URL of the search API endpoint
var searchEndpointUrl = "https://example.com/search?q=";

// Get the search input field and results container
var searchInput = document.getElementById("search-input");
var searchResults = document.getElementById("search-results");

// Function to display search results
function showResults() {
  // Get the user's search query
  var query = searchInput.value.toLowerCase();

  // Clear the search results container
  searchResults.innerHTML = "";

  // If the search query is empty, hide the search results container and return
  if (query === "") {
    searchResults.style.display = "none";
    return;
  }

  // Fetch search suggestions from the API endpoint
  fetch(searchEndpointUrl + query)
    .then(response => response.json())
    .then(data => {
      // Loop through the search suggestions and add them to the search results container
      data.forEach(result => {
        // Create a link for the search suggestion
        var link = document.createElement("a");
        link.setAttribute("href", "#");
        link.textContent = result;

        // Add the link to the search results container
        searchResults.appendChild(link);

        // Show the search results container
        searchResults.style.display = "block";
      });

      // Hide the search results container if there are no results
      if (data.length === 0) {
        searchResults.style.display = "none";
      }
    })
    .catch(error => {
      console.error("Error fetching search suggestions:", error);
    });
}

// Add event listeners for the search input field
searchInput.addEventListener("input", showResults);
searchInput.addEventListener("focus", showResults);
searchInput.addEventListener("blur", function() {
  setTimeout(function() {
    searchResults.style.display = "none";
  }, 200);
});

// Add event listeners for the search result links
searchResults.addEventListener("click", function(event) {
  // Prevent the link from navigating
  event.preventDefault();

  // Set the search input field value to the clicked link
  searchInput.value = event.target.textContent;

  // Hide the search results container
  searchResults.style.display = "none";
});



*/
