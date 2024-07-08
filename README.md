
Features of our App
•	MainActivity
This code defines a `MainActivity` for an Android app, where two buttons allow navigation to `LoginActivity` and `SignupActivity`. It also checks if a user is already authenticated with Firebase, redirecting them to `DestinationListActivity` if so.
•	LoginActivity
This code defines a `LoginActivity` for an Android app, where users can log in with their email and password using Firebase Authentication. It also includes options to navigate to password recovery or registration activities.
•	ForgotPasswordActivity
This code defines a `ForgotPasswordActivity` for an Android app, allowing users to request a password reset via Firebase Authentication by entering their email. When the reset button is clicked, an email is sent if the input is valid, and the user is notified of the success or failure.
•	SignupActivity
This `SignupActivity` defines the UI elements for user registration in an Android app, including name, email, and password fields. It also provides a link to navigate back to the login screen. Currently, the registration functionality (`registerUser` method) would have used Firebase Authentication to register users and redirect to `DestinationListActivity` upon success.
•	DestinationListActivity
This `DestinationListActivity` sets up a RecyclerView to display a list of favorite places retrieved from SQLite using `DatabaseHelper`. It initializes an adapter (`FavoritePlacesAdapter`) to populate the RecyclerView with data and handle item click events. Clicking on a place item navigates to `PlaceDetailsActivity`, passing along details like name, location, and image resource ID via intent extras for display.
•	FlightSelectionActivity
This `FlightSelectionActivity` manages a list of flights using Firebase Realtime Database. It initializes a RecyclerView (`rvFlights`) with a custom adapter (`FlightAdapter`) to display flight data fetched from the Firebase database. It provides buttons (`btnFilter`, `btnSort`, `btnProceedToPayment`) to filter flights, sort them, and proceed to a payment selection activity (`PaymentSelectionActivity`). Firebase is utilized through `FirebaseDatabase` and `DatabaseReference` to fetch and display flight information dynamically. Dialogs (`showFilterDialog` and `showSortDialog`) allow users to select filter and sorting options respectively.
•	PlaceDetailsActivity
This `PlaceDetailsActivity` in an Android app displays details of a specific place. It initializes views to show the place's name (`placeNameTextView`), location (`placeLocationTextView`), and an image carousel (`imageCarousel`) using a ViewPager with a single image adapter (`ImageCarouselAdapter`). Users can click the "Book Now" button (`bookNowButton`) to navigate to `PaymentSelectionActivity` for booking purposes, using data passed via intents from the previous activity.
•	PaymentSelectionActivity
This `PaymentSelectionActivity` sets up a radio button group (`radioGroup`) for selecting a payment method and a button (`btnConfirmPayment`) to confirm the payment selection. When a payment method is selected and confirmed, a toast message displays the chosen method. Currently, the `storePaymentDetails` method, which would have stored payment details using Firebase Firestore upon confirmation. It includes handling user authentication and storing payment details in a Firestore collection named "payments".
•	ConfirmationActivity
This `ConfirmationActivity` in an Android app handles the confirmation of a flight booking. It initializes a `DatabaseHelper` to interact with SQLite for storing booking details. Upon creation, it retrieves flight details (`flightName`, `flightDetails`, `flightPrice`) from the intent extras sent from the previous activity (`FlightSelectionActivity`). It then stores these details using `dbHelper.addBooking()` and displays a confirmation message (`confirmationMessage`) in a `TextView` (`confirmationText`). This activity ensures that booking information is persisted locally in SQLite after the user confirms their flight selection.
•	BannerAdAcivity
This `BannerAdActivity` sets up an activity to display a banner ad with a download button (`downloadButton`). When clicked, the button opens a web browser intent to navigate to a specified URL (`https://play.google.com/store/apps/details?id=com.example.final_travel_apppp` in this case), allowing users to download the app associated with the link. The activity is straightforward, focusing on redirecting users to the Play Store page for the app upon clicking the download button.
Adapters:
•	FavoritePlacesAdapter
This `FavoritePlacesAdapter` class is used in an Android app to populate a RecyclerView with a list of favorite places (`favoritePlaces`). It implements an `OnItemClickListener` interface to handle item clicks on each place item. This adapter is designed to efficiently manage and display a list of favorite places, allowing interaction through item click events defined in the `OnItemClickListener`. It facilitates dynamic updates and interactions within the RecyclerView based on user interactions or data changes.
•	Constructor: Initializes the adapter with a list of `favoritePlaces` and an `OnItemClickListener`.
•	onCreateViewHolder: Inflates the layout (`item_favorite_place.xml`) for each item in the RecyclerView.
•	onBindViewHolder: Binds data from `favoritePlaces` list to the ViewHolder. Sets the name, location, and image of each place item. Also sets a click listener to handle item clicks and invokes the `listener.onItemClick(place)` method.
•	ViewHolder class: Holds references to `TextViews` (`placeName`, `placeLocation`) and an `ImageView` (`placeImage`) for displaying place details.

•	FlightAdapter
The FlightAdapter is a custom RecyclerView.Adapter designed to display a list of Flight objects. It inflates a layout (item_flight.xml) for each item in the list and binds flight data to the views within the layout. The FlightViewHolder inner class holds references to the views that display the flight name, details, and price
•	ImageCrouselAdapter
The `ImageCarouselAdapter` is a custom `PagerAdapter` for displaying a carousel of images in a `ViewPager`. It takes a `Context` and a list of image resource IDs, inflates `ImageView` instances for each image, and manages the addition and removal of these views within the `ViewPager`.
Model Class
•	Place
The `Place` class represents a place with properties such as ID, name, description, location, and image resource ID. It includes getters and setters for each of these fields to enable accessing and modifying their values.
•	Flight
The `Flight` class defines a simple model for flight information with three properties: `name`, `details`, and `price`. It includes a constructor to initialize these properties upon object creation and getter methods to retrieve their values.
•	Constructor: Initializes a `Flight` object with a name, details, and price.
•	Getter Methods: Retrieve the name, details, and price of the flight.

This class is typically used to represent individual flights within a travel application, providing essential details that can be displayed in lists or detailed views.
•	Booking
The `Booking` class represents a booking made by a user for a flight, storing information such as booking ID, user ID, flight name, details, and price. It provides getters and setters for each of these properties to manage and retrieve booking information.
•	Properties: Includes fields for `bookingId`, `userId`, `flightName`, `flightDetails`, and `flightPrice`.
•	Getters and Setters: Allow access to these properties for setting and retrieving booking details.
This class is essential for managing and displaying booking information within a travel application, facilitating interaction between users and their booked flights.
Database
•	DatabaseHelper
The `DatabaseHelper` class manages a SQLite database for a travel app. It defines tables for `bookings` (with columns for booking details) and `favorite_places` (with columns for place details). Methods include adding bookings or favorite places, retrieving all bookings or favorite places as lists of corresponding model objects (`Booking` or `Place`), and handling database creation and upgrades. This class ensures structured data storage and retrieval essential for managing user interactions and preferences within the app.


GitHubLink:

