import i18n from "i18next";
import { reactI18nextModule } from "react-i18next";

import translationEN from './en/en';
import translationPL from './pl/pl';

const resources = {
    en: {
        translation: translationEN
    },
    pl: {
        translation: translationPL
    }
};

i18n
    .use(reactI18nextModule)
    .init({
        resources,
        lng: "en",
        keySeparator: false,
        interpolation: {
            escapeValue: false
        }
    });


export default i18n;