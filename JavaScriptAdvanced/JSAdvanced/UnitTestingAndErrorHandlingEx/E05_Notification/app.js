function notify(message) {
  let notification = document.getElementById('notification');
  notification.textContent = message;
  notification.style.display = 'block'; 
  notification.addEventListener('click', hideDiv);

  function hideDiv(e) {
    e.target.style.display = 'none';
  }
}