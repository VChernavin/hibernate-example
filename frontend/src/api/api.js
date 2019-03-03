import axios from "axios";


const errorHandler = error => {

  console.log(Object.keys(error));
  alert(error.response === undefined ? error.message : error.response.data.message)
};

export const getData = (objectType, setStateHandler) => {
  return axios.get(`http://localhost:8080/api/${objectType}`).then(setStateHandler);

};

export const onDelete = (objectType, setStateHandler, id) => {
  const promises = [];
  id.forEach(value => {
    const url = `http://localhost:8080/api/${objectType}/${value}`;
    promises.push(axios.delete(url));
  });
  Promise.all(promises).then(() => {
    getData(objectType, setStateHandler)
  }).catch(errorHandler);
};

export const onAdd = (objectType, setStateHandler, object) => {
  const url = `http://localhost:8080/api/${objectType}`;

  axios.post(url, object).then(() => {
    getData(objectType, setStateHandler)
  }).catch(errorHandler);

};

export const onUpdate = (objectType, setStateHandler, object) => {
  const url = `http://localhost:8080/api/${objectType}`;

  axios.put(url, object).then(() => {
    getData(objectType, setStateHandler)
  }).catch(errorHandler);

};