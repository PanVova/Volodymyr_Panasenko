Feature: Upload File

  Background: User authorized

  Scenario Outline: User can upload file to his dropbox folder
    Given I want upload "<filename>" to folder "<folder_dropbox>" with name "<filename_dropbox>"
    When I send POST request to "https://content.dropboxapi.com/2/files/upload"

    Examples:
      | filename                                 | folder_dropbox       | filename_dropbox |
      | /photos/photo1.jpeg | /photos | first.png        |
      | /photos/photo2.jpeg | /photos | second.png       |