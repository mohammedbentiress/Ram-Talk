<html>
  <head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="css/form-login.css" />
  </head>
  <body>
    <header>
      <img src="images/svg/logo-white.svg" alt="" />
    </header>
    <h1>LOGIN</h1>
    <form action="verification.php" method="POST">
      <div class="control">
        <div class="user-icon">
          <img src="images/svg/baseline-person-24px.svg" alt="" />
        </div>
        <input type="text" name="username" placeholder="Username" />
      </div>
      <div class="control">
        <div class="user-icon">
          <img src="images/svg/baseline-lock-24px.svg" alt="" />
        </div>
        <input type="password" name="password" placeholder="Password" />
      </div>
      <div class="control">
        <input type="submit" name="connecte" value="se connecter" />
        <div class="arrow">
          <img src="images/svg/arrow-right-solid.svg" alt="" />
        </div>
      </div>
      <?php
			if (isset($_GET['erreur'])) {
			echo '<div class="msg">
            <h2>les données saisies sont erronées !</h2>
          </div>';
			} 
		 if (isset($_GET['deco'])) {
			echo '<div class="msg" style="display:none;">
                    <h2>les données saisies sont erronées !</h2>
                </div>';
			}  ?>
    </form>
  </body>
</html>