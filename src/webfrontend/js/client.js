

  // VARIABLES =============================================================
  var TOKEN_KEY = "jwtToken"


  // FUNCTIONS =============================================================
  function getJwtToken() {
    return localStorage.getItem(TOKEN_KEY);
  }

  function setJwtToken(token) {
    localStorage.setItem(TOKEN_KEY, token);
  }

  function removeJwtToken() {
    localStorage.removeItem(TOKEN_KEY);
  }


  //携带token
  function createAuthorizationTokenHeader() {
    var token = getJwtToken();
    if (token) {
      return {"Authorization": "Bearer " + token};
    } else {
      return {};
    }
  }


