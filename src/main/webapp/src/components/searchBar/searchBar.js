
import './searchBar.css';

import React from "react";

import InputSearch from "../inputSearch/InputSearch";
import CalendarSearch from "../calendarSearch/CalendarSearch";
import i18n from "../../i18n/i18n"

const SearchBar = ()=> {

    return(
            <form className={"containerSearchBar"}>
                <label>
                    <InputSearch placeholder={i18n.t("city")}name={i18n.t("takeFrom")} />
                </label>
                <label>
                    <InputSearch placeholder={i18n.t("city")} name={i18n.t("returnTo")} />
                </label>
                <label>
                    <CalendarSearch name={i18n.t("takeTime")} />
                </label>
                <label>
                    <CalendarSearch name={i18n.t("returnTime")} />
                </label>
                <input className={"button"} type="submit" value={i18n.t("submit")} />
            </form>
    )
}

export default SearchBar;
