firebase.auth().currentUser.getIdToken().then((token) => {
    // Send the token to the backend
    fetch('/api/auth/user', {
        method: 'GET',
        headers: {
            'Authorization': `Bearer ${token}`,
        },
    })
    .then((response) => response.json())
    .then((data) => {
        if (response.ok) {
            console.log('User data:', data);
            // Display user data in the UI
            document.getElementById('userName').innerText = data.userName || 'No Name';
            document.getElementById('userEmail').innerText = data.userEmail || 'No Email';
            document.getElementById('profilePic').src = data.profilePic || 'https://via.placeholder.com/40';
        } else {
            console.error('Error fetching user data:', data.message);
            alert(data.message);
        }
    })
    .catch((error) => {
        console.error('Error:', error);
        alert('Failed to fetch user data');
    });
});
