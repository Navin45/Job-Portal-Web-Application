import axios from 'axios';

const API_URL = 'http://localhost:8080/api/posts';

export const getAllPosts = () => axios.get(`${API_URL}/all`);
export const searchPosts = (text) => axios.get(`${API_URL}/search/${text}`);
export const addPost = (data) => axios.post(`${API_URL}/add`, data);
