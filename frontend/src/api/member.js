import { apiInstance } from "./index.js";

const api = apiInstance();

async function login(user, success, fail) {
  console.log(user)
  await api.post(`/api/auth/login`, JSON.stringify(user)).then(success).catch(fail);
}

async function findById(userId, success, fail) {
  api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
  await api.get(`/api/auth/info/${userId}`).then(success).catch(fail);
}

async function tokenRegeneration(user, success, fail) {
  api.defaults.headers["refresh-token"] = sessionStorage.getItem("refresh-token"); //axios header에 refresh-token 셋팅
  await api.post(`/api/auth/refresh`, user).then(success).catch(fail);
}

async function logout(userId, success, fail) {
  await api.get(`/api/auth/logout/${userId}`).then(success).catch(fail);
}

export { login, findById, tokenRegeneration, logout };
