const firebaseConfig = {
            apiKey: "AIzaSyCvkgcTBpPVzTIzrkHc4pc6CM2QQClMxos",
            authDomain: "play-with-playwright.firebaseapp.com"
        };

        firebase.initializeApp(firebaseConfig);
        const auth = firebase.auth();

        document.addEventListener("DOMContentLoaded", () => {
            firebase.auth().onAuthStateChanged((user) => {
                if (user) {
                    // Display the user information
                    document.getElementById("userName").innerText = user.displayName || "No Name Provided";
                    document.getElementById("userEmail").innerText = user.email;
                    document.getElementById("userProfilePic").src = user.photoURL || "https://via.placeholder.com/40";
                } else {
                    // Redirect to login page if user is not authenticated
                    window.location.href = "login.html";
                }
            });

            // Logout functionality
            document.getElementById("logoutButton").addEventListener("click", () => {
                firebase.auth().signOut().then(() => {
                    window.location.href = "login.html";
                }).catch((error) => {
                    console.error("Logout Error:", error);
                });
            });
        });