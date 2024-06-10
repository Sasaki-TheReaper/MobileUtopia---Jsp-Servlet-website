<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Contact Page</title>
 <%@ include file="header.jsp" %>  
<style>
  body { font-family: Arial, sans-serif; background-color: #f4f4f4; height: 100vh;}
  .navbar { display: flex; justify-content: space-between; align-items: center; padding: 1rem; background-color: #333; }
  .navbar a { text-decoration: none; color: #fff; margin-left: 1rem; }
  .contact-form { display: flex; justify-content: space-between; margin: 2rem; }
  .contact-info, .form-container { flex: 1; background-color: #fff; padding: 1rem; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
  .contact-info img { max-width: 100%; }
  .form-container form { display: flex; flex-direction: column; }
  .form-container label { margin-top: 1rem; }
  .form-container input, .form-container textarea { padding: 0.5rem; margin-top: 0.5rem; }
  .form-container button { padding: 1rem; margin-top: 1rem; background-color: #007bff; color: white; border: none; cursor: pointer; }
  .footer { display: flex; justify-content: space-between; align-items: center; padding: 1rem; background-color: #333; color: #fff; }
  .footer p { margin: 0; }
  .social-icons { display: flex; }
  .social-icons img { width: 24px; margin-left: 1rem; }
  .contact-info{display: flex; justify-content: center; align-items: center; flex-direction: column;}
  
</style>
</head>
<body>



<div class="contact-form">
  <!-- Contact information with image and details -->
  <div class="contact-info">
    <img src="img.jpeg" >
    
  </div>

  <!-- Contact form -->
  <div class="form-container">
    <form id="contactForm" action="../FeedbackServlet" method="post">
      <label for="fullName">Tell Us your name*</label>
      <input type="text" id="fullName" placeholder="First Name Last Name" required>

      <label for="email">Enter Your Email*</label>
      <input type="email" id="email" name="email" placeholder="example@example.com" required>

      <label for="phone">Enter Phone Number (optional)</label>
      <input type="tel" id="phone" name="phone" placeholder="eg: +9779812309090">

      <label for="message">Message*</label>
      <textarea id="message" placeholder="Write Us a Message" name="message" required></textarea>

      <button type="submit">Send Message</button>
    </form>
  </div>
</div>

</body>
 <%@ include file="footer.jsp" %>  

</html>