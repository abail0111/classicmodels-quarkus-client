var openMenu;
var showOverlay = function () {
  document.getElementById('overlay').classList.remove('hidden');
};

var hideOverlay = function () {
  document.getElementById('overlay').classList.add('hidden');
};
var showMenu = function (name) {
  openMenu = name;
  document.getElementById(openMenu).classList.remove('closed');
  document.getElementById(openMenu).classList.add('opened');
  showOverlay();
};

var hideMenu = function () {
  document.getElementById(openMenu).classList.add('closed');
  document.getElementById(openMenu).classList.remove('opened');
  hideOverlay();
};