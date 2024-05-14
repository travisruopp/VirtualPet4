package org.wecancodeit.virtualpet4.Repositories;

import java.net.*;
import java.io.*;

/**
 * Abstract class that models the connection between the API and the MVC.
 */
public abstract class ClientHTTP {
    private final String baseURLString;

    public ClientHTTP(String baseURLString) {
        this.baseURLString = baseURLString;
    }

    /**
     * Method to get the url for the getter methods
     * 
     * @param urlString url extension
     * 
     * @return full url for API
     * 
     * @throws Exception
     */
    protected String getURL(String urlString) throws Exception {
        HttpURLConnection connection = null;
        StringBuffer response = new StringBuffer();
        try {

            // Create a URL object with the API endpoint
            URL url = new URL(baseURLString + urlString);
            // Open a connection to the URL
            connection = (HttpURLConnection) url.openConnection();

            // Set request method
            connection.setRequestMethod("GET");

            // Set request headers if needed
            connection.setRequestProperty("Content-Type", "application/json");

            // Get the response code
            int responseCode = connection.getResponseCode();

            // If the response code is OK (200)
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Create a BufferedReader to read the response
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;

                // Read the response line by line
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
            } else {
                throw new Exception(responseCode + " Response Code from urlGet");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (connection != null) {
                // Close the connection putting it here ensures no memory leak
                connection.disconnect();
            }
        }
        return response.toString();
    }

    /**
     * Method to save and object as a json
     * 
     * @param jsonString the API json
     * 
     * @return String Json
     * 
     * @throws Exception
     */
    protected String saveObject(String jsonString) throws Exception {
        HttpURLConnection connection = null;
        StringBuffer response = new StringBuffer();
        try {

            // Create a URL object with the API endpoint
            URL url = new URL(baseURLString);

            // Open connection to the URL
            connection = (HttpURLConnection) url.openConnection();

            // Set request method
            connection.setRequestMethod("POST");

            // Set request headers if needed
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Write the JSON data to the connection's output stream
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonString.getBytes("utf-8");
                os.write(input, 0, input.length);
            } catch (Exception ex) {
                throw ex;
            }
            // Get the response code
            int responseCode = connection.getResponseCode();

            // If the response code is OK (200)
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Create a BufferedReader to read the response
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;

                // Read the response line by line
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
            } else {
                throw new Exception(responseCode + "Response Code from urlGet");
            }
            connection.disconnect();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (connection != null) {
                // Close the connection putting it here ensures no memory leak
                connection.disconnect();
            }
        }
        return response.toString();
    }

    /**
     * Method to delete an object by id
     * 
     * @param id object id
     * 
     * @return true if deleted
     */
    public boolean deleteObject(Long id) {
        HttpURLConnection connection = null;
        boolean response = false;
        try {
            // Create a URL object with the API endpoint
            URL url = new URL(baseURLString + id.toString());

            // Open connection to the URL
            connection = (HttpURLConnection) url.openConnection();

            // Set request method
            connection.setRequestMethod("DELETE");

            // Set request headers if needed
            connection.setRequestProperty("Content-Type", "application/json");

            // Get the response code
            int responseCode = connection.getResponseCode();

            // If the response code is OK (200)
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Create a BufferedReader to read the response
                response = true;
            } else {
                throw new Exception(responseCode + "Response Code from deleteObject");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (connection != null) {
                // Close the connection putting it here ensures no memory leak
                connection.disconnect();
            }
        }
        return response;
    }
}
