import './AppRouter.css';
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";


import React from "react";
import App from "../app/App";
import Login from "../login/Login";
import { withNamespaces } from 'react-i18next';
import Fleet from "../fleet/Fleet";
import Contact from "../contact/Contact";
import UserConditions from "../userConditions/UserConditions";
import Register from "../components/register/Register";
import interceptors from "../interceptors/Interceptors";
import 'react-app-polyfill/stable';

function AppRouter() {
  return (
          <Router>
              <Switch>
                  <Route path="/" component={App} exact />
                  <Route path="/login" component={Login} exact />
                  <Route path="/register" component={Register} exact />
                  <Route path="/fleet" component={Fleet} exact />
                  <Route path="/contact" component={Contact} exact />
                  <Route path="/userConditions" component={UserConditions} exact />
              </Switch>
          </Router>
  );
}

export default withNamespaces()(AppRouter);
