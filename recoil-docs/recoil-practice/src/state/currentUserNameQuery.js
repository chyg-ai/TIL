import { selector } from "recoil";
import currentUserIDState from "./currentUserIDState";

const currentUserNameQuery = selector({
  key: "CurrentUserName",
  get: async ({ get }) => {
    const response = await myDBQuery({
      userID: get(currentUserIDState),
    });

    // Error Handling
    if (response.error) {
      throw response.error;
    }

    return response.name;
  },
});

export default currentUserNameQuery;
