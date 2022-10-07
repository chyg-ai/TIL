const expressHandlebars = require("express-handlebars");
app.engine(
  "handlebars",
  expressHandlebars({
    defaultLayout: "main",
  })
);
app.set("view engine", "handlebars");

// app.engine(
//   ".hbs",
//   expressHandlebars({
//     extname: ".hbs",
//     defaultLayout: "main",
//     helpers: {
//       section: function (name, options) {
//         if (!this._sections) this._sections = {};
//         this._sections[name] = options.fn(this);
//         return null;
//       },
//     },
//   })
// );
// app.set("view engine", ".hbs");
